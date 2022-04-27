package comportement.state.exercice1;

public class AvionImpl implements Avion {
    private State state;

    public AvionImpl() {
        this.state = new EtatEnPiste(this);
    }

    @Override
    public void sortirDuGarage() {
        state.executeSortirDuGarage();
    }

    @Override
    public void entrerAuGarage() {
        state.executeEntrerAuGarage();
    }

    @Override
    public void decoller() {
        state.executeDecoller();
    }

    @Override
    public void atterir() {
        state.executeAtterir();
    }

    @Override
    public void doActivity() throws InterruptedException {
        state.executeDoActivity();
    }

    abstract class State {
        protected AvionImpl avion;

        State(AvionImpl avion) {
            this.avion = avion;
        }

        abstract void executeSortirDuGarage();

        abstract void executeEntrerAuGarage();

        abstract void executeDecoller();

        abstract void executeAtterir();

        abstract void executeDoActivity() throws InterruptedException;
    }

    class EtatEnPiste extends State {

        EtatEnPiste(AvionImpl avion) {
            super(avion);
        }

        @Override
        void executeSortirDuGarage() {
            System.out.println("Impossible je suis en piste");
        }

        @Override
        void executeEntrerAuGarage() {
            System.out.println("Transition d'etat de En piste vers Garage");
            super.avion.state = new EtatAuGarage(super.avion);
        }

        @Override
        void executeDecoller() {
            System.out.println("Transition d'etat de En piste vers Decoller");
            super.avion.state = new EtatEnLair(super.avion);
        }

        @Override
        void executeAtterir() {
            System.out.println("Impossible je suis deja en piste");
        }

        @Override
        void executeDoActivity() throws InterruptedException {
            Thread.sleep(2000);
            System.out.println("Activite de l'etat en piste.... ca va prendre du temps!");
        }
    }

    class EtatAuGarage extends State {
        EtatAuGarage(AvionImpl avion) {
            super(avion);
        }

        @Override
        void executeSortirDuGarage() {
            System.out.println("Transition d'etat de Au garage vers Piste");
            super.avion.state = new EtatEnPiste(super.avion);
        }

        @Override
        void executeEntrerAuGarage() {
            System.out.println("Impossible je suis deja au garage");
        }

        @Override
        void executeDecoller() {
            System.out.println("Impossible de decoller je suis deja au garage");
        }

        @Override
        void executeAtterir() {
            System.out.println("Impossible d atterir je suis deja au garage");
        }

        @Override
        void executeDoActivity() throws InterruptedException {
            Thread.sleep(2000);
            System.out.println("Activite de l'etat au garage.... ca va prendre du temps!");
        }
    }

    class EtatEnLair extends State {
        EtatEnLair(AvionImpl avion) {
            super(avion);
        }

        @Override
        void executeSortirDuGarage() {
            System.out.println("Impossible de sortir je suis deja en lair");
        }

        @Override
        void executeEntrerAuGarage() {
            System.out.println("Impossible dentrer je suis deja en lair");
        }

        @Override
        void executeDecoller() {
            System.out.println("Impossible de decoller je suis deja en lair");
        }

        @Override
        void executeAtterir() {
            System.out.println("Transition d'etat de en lair vers Piste");
            super.avion.state = new EtatEnPiste(super.avion);
        }

        @Override
        void executeDoActivity() throws InterruptedException {
            Thread.sleep(2000);
            System.out.println("Activite de l'etat en lair.... ca va prendre du temps!");
        }
    }
}
