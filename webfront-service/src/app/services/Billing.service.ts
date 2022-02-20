import { Subject } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';




@Injectable()
export class BillingService{
  billSubject = new Subject<any[]>();
  private bill:any;
  constructor(private httpClient: HttpClient) {

  }
  emitBillSubject(): void {
    this.billSubject.next(this.bill);
  }
  getBillFromGateway(): void {
    this.httpClient.get<any[]>('http://localhost:8887/BILLING-SERVICE/fullBill/1')
      .subscribe(
        (response) => {
          this.bill = response;
          console.log(response);
          this.emitBillSubject();
        },
        (error) => {
          console.log('erreur de chargement ' + error);
        }
      );
  }
}