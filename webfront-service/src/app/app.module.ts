import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {  RouterModule, Routes  } from '@angular/router';
import { AppComponent } from './app.component';
import { BillingService } from './services/Billing.service';
import { SingleBillComponent } from './Bills/single-bill/single-bill.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

const appRoutes: Routes = [
  { path: 'bill', component: SingleBillComponent },

  //{ path: '**', redirectTo: '/not-found' } // doit etre a la fin
];

@NgModule({
  declarations: [
    AppComponent,
    SingleBillComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    //AppRoutingModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes)

  ],
  providers: [BillingService],
  bootstrap: [AppComponent]
})
export class AppModule { }
