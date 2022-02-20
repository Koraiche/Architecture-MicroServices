import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { BillingService } from 'src/app/services/Billing.service';

@Component({
  selector: 'app-single-bill',
  templateUrl: './single-bill.component.html',
  styleUrls: ['./single-bill.component.css']
})
export class SingleBillComponent implements OnInit {

  bill: any;
  billSubscription!: Subscription;
  constructor(private billingService:BillingService, private httpClient:HttpClient) { 

  }

  ngOnInit(): void {
    this.getBillFromGateway();
  }
  getBillFromGateway(): void {
    this.httpClient.get<any[]>('http://localhost:8887/BILLING-SERVICE/fullBill/1')
      .subscribe(
        (response) => {
          this.bill = response;
          console.log(response);
          //this.emitBillSubject();
        },
        (error) => {
          console.log('erreur de chargement ' + error);
        }
      );
  }
}
