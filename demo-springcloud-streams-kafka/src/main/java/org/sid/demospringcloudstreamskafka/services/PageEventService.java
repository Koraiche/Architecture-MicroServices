package org.sid.demospringcloudstreamskafka.services;


import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.TimeWindows;
import org.sid.demospringcloudstreamskafka.entities.PageEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Date;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Service
public class PageEventService {
    //spring clous stream utilise un channel qui porte le meme nom que le fonction ex :
    // pageeventconsumer -> pageEventConsumer-in-0,  pour que ca marche il faut allez vers app.properties et ajouter
    // un nouveau topic que le bean va vizer au lieux de pageEventConsumer-in-0 (binding avec le topic qu'on veut)
    @Bean
    public Consumer<PageEvent> pageEventConsumer(){
        return (input)->{
            System.out.println("**********************************");
            System.out.println(input.toString());
            System.out.println("**********************************");
        };
    }
    @Bean //le comportement par defaut des objet supplier c'est que chaque second, cette fonction va sexecuter
    public Supplier<PageEvent> pageEventSupplier(){
        return ()->new PageEvent(Math.random()>0.5?"P1":"P2", Math.random()>0.5?"U1":"U2",new Date(), new Random().nextInt(9000));
    }

    @Bean
    public Function<PageEvent, PageEvent> pageEventFunction(){
        return (input)->{
            input.setName("L:"+input.getName().length());
            input.setUser("UUUUUUUU");
            return input;
        };
    }
    @Bean
    public Function<KStream<String,PageEvent>, KStream<String,Long>> kStreamFunction(){
        return (input)->{
            return input
                    .filter((k,v)->v.getDuration()>100)
                    .map((k,v)->new KeyValue<>(v.getName(),0L))
                    .groupBy((k,v)->k,Grouped.with(Serdes.String(),Serdes.Long()))//ici lobjet est devenu Ktable et non plus KStream, on va fair un toStream pour revenir ver KStream
                    .windowedBy(TimeWindows.of(Duration.ofMillis(5000)))
                    .count(Materialized.as("page-count"))
                    .toStream()
                    .map((k,v)->new KeyValue<>("=>"+k.window().startTime()+k.window().endTime()+k.key(),v));//on fait ca car la cle est devenu de type window alors qu'on doit retourner des cle de type string
        };

    }
}
