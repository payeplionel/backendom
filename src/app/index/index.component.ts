import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { RetraitserviceService } from '../retraitservice.service';

interface Food {
  value: string;
  viewValue: string;
}


@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {
  option = "Orange Money";
  frais = 0;
  fraisc = 0;
  values = 0;
  retrait: any;
  retraitc: any;
  nombreRetrait = 0;
  tabRetrait: any;
  attention = "";
  concurence = "";
  coupures = [{
    id: '25',
    value: '25',
   },
   {
    id: '50',
    value: '50',
   },
   {
    id: '100',
    value: '100',
   },
   {
    id: '500',
    value: '500',
   },
   {
    id: '1000',
    value: '1000',
   },
   {
    id: '2000',
    value: '2000',
   },
   {
    id: '5000',
    value: '5000',
   },
   {
    id: '10000',
    value: '10000',
   }]

   selected!: number;



  constructor(private retraiservice: RetraitserviceService) {
  }

  ngOnInit(): void {

  }

  changeom() {
    this.option = "Orange Money";
   
  }

  changemomo() {
    this.option = "Mobile Money";
  }

  onKey(event: any) { 
    if ((event.target.value >= 100) && (event.target.value % 5 == 0) && (this.isInt(event.target.value) == true)&&(event.target.value <= 500000)) {
      if (this.option == "Orange Money") {
        let resp = this.retraiservice.getRetrait("om", event.target.value, this.selected);
        resp.subscribe(data => {
          this.retrait = data;
          this.frais = this.retrait.frais;
          this.nombreRetrait = this.retrait.sommes.length;
          this.tabRetrait = this.retrait.sommes;
        });

        let res = this.retraiservice.getRetrait("momo", event.target.value, this.selected);
        res.subscribe(data => {
          this.retraitc = data;
          this.fraisc = this.retraitc.frais;
         
          if (this.fraisc < this.frais) {

            this.concurence = "Mobile money propose des frais à " + this.fraisc + " pour le même montant";
          }
          else {
            this.concurence = "";
          }
        });


        this.attention = "";
      }
      else if ((this.option == "Mobile Money") && (event.target.value % 5 == 0) && (this.isInt(event.target.value) == true) &&(event.target.value <= 500000)) {
        let resp = this.retraiservice.getRetrait("momo", event.target.value, this.selected);
        resp.subscribe(data => {
          this.retrait = data;
          this.frais = this.retrait.frais;
          this.nombreRetrait = this.retrait.sommes.length;
          this.tabRetrait = this.retrait.sommes;

        });

        let res = this.retraiservice.getRetrait("momo", event.target.value, this.selected);
        res.subscribe(data => {
          this.retraitc = data;
          this.fraisc = this.retraitc.frais;
         
          if (this.fraisc < this.frais) {

            this.concurence = "Orange money propose des frais à " + this.fraisc + " pour le même montant";
          }
          else {
            this.concurence = "";
          }
        });

        this.attention = "";
      }
    }
    else if ((this.isInt(event.target.value) == false) || (event.target.value % 5 != 0) || (event.target.value > 500000)) {
      this.attention = "Nb : La sommes doit respecter le système monétaire du Cameroun et doit être en chiffre et être inférieur à 500.000 xaf";
    }
    else {
      this.nombreRetrait = 0;
      this.frais = 0;
    }
  }

  isInt(value: any) {
    var er = /^-?[0-9]+$/;
    return er.test(value);
  }


}
