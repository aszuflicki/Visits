import { Injectable } from '@angular/core';
import { Visit } from './visit';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VisitsService {

  constructor(private http: HttpClient) { }

    url: string = "/api/visit/"

    submitVisit(date:string, ip: string): Observable<Visit> {
      const httpOptions = {
          headers: new HttpHeaders({
            'Content-Type':  'application/json'
          })
        };

      return this.http.post<Visit>(this.url, { date, ip }, httpOptions);
    }

//     likeQuote(quote: any, user: any): void {
//     const httpOptions = {
//       headers: new HttpHeaders({
//         'Content-Type':  'application/json'
//       })
//     };
//       this.http.post<Like>(this.quotesUrl + "/like", { quote, user }, httpOptions).subscribe();
//     }
}
