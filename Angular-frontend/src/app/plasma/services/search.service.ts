

import { Injectable } from "@angular/core";
import { Http, Response } from '@angular/http';
import {
  HttpClient,
  HttpHeaders,
  HttpErrorResponse
} from "@angular/common/http";
import { BehaviorSubject, throwError } from "rxjs";
import { catchError } from "rxjs/operators";
@Injectable({
  providedIn: "root"
})
export class SearchService {
  console: any;
  // private nlpserviceurl: 'http://localhost:8098/api/v1/';

  // constructor(private http: Http) {
  //   console.log("Hi how are you ");
  //   this.getData();

  // }

  getData() {
    // return this.http.get(this.nlpserviceurl);
    // .toPromise()
    //            .then(response => response.json().data as Hero[])
    //            .catch(this.handleError);
    console.log("Hi how are you ");
  }
}