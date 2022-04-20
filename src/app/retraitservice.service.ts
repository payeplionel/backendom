import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RetraitserviceService {
  distant = "https://app-programmation-dynamique.herokuapp.com/";
  local = "http://localhost:8080/retrait/";


  constructor(private http: HttpClient) { }

  getRetrait(type: string, montant: number, coupures: number) {
    return this.http.get(this.local + type + "?montant=" + montant+"&coupures="+ coupures);
  }
}
