import { UserLogin } from './../tsclasses/user-login';

import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable()
  export class UserLoginService {
    response: any;
  private loginUrl = 'http://localhost:8133/api/user';
  private errorStatus: string;
  private errorBody: string;
  constructor(private http: HttpClient) { }
  login(user: UserLogin) {


    return this.http
    .post(this.loginUrl + '', user, {observe: 'response'})
    .pipe(catchError(this.handleError));
    }

  setCookie(cname: string, cvalue: string, exdays: number) {
  const date = new Date();
    date.setTime(date.getTime() + (exdays * 24 * 60 * 60 * 1000));
    const expires = `expires=${date.toUTCString()}`;
    document.cookie =  `${cname}=${cvalue};${expires};path=/`;
  }

  getCookie(cname: string) {
    const name = cname + '=';
    const ca = document.cookie.split(';');
    for (let i = 0; i < ca.length; i++) {
      let c = ca[i];
      while (c.charAt(0) === '') {
        c = c.substring(1);
      }
      if (c.indexOf(name) === 0) {
        return c.substring(name.length, c.length);
      }
      }
      return '';
      }

      deleteCookie(cname: string) {
        document.cookie = `${cname}=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;`;

      }
      private handleError(error: HttpErrorResponse) {
        if (error.error instanceof ErrorEvent) {
          console.log('An error occured :', error.error.message);
        } else {
          this.errorStatus = `${error.status}`;
          console.log('Error msg', this.errorStatus);
          this.errorBody = `${error.error}`;
          console.log(
            `Backened returned code ${error.status},` + `body was :${error.error}`
          );
        }
        return throwError(this.errorStatus);
      }
    }
