import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApiService {


  apiURL: string = '/api';

  authenticated = false;

  constructor(private httpClient: HttpClient) { }

get(endpoint: string, params?: any, reqOpts?: any) {
    if (!reqOpts) {
      reqOpts = {
        params: new HttpParams()
      };
    }

    if (params) {
      reqOpts.params = new HttpParams();
      for (let k in params) {
        reqOpts.params.set(k, params[k]);
      }
    }

    return this.httpClient.get(this.apiURL + '/' + endpoint, reqOpts);
  }

  post(endpoint: string, body: any, reqOpts?: any) {
    return this.httpClient.post(this.apiURL + '/' + endpoint, body, reqOpts);
  }

  authenticate(credentials, callback) {

        const headers = new HttpHeaders(credentials ? {
            authorization : 'Basic ' + btoa(credentials.username + ':' + credentials.password)
        } : {});


        let seq = this.post('login', '', {headers: headers});

        seq.subscribe((res: any) => {
                    if (res.name) {
                        this.authenticated = true;
                    } else {
                        this.authenticated = false;
                    }
                  }, err => {
                    console.error('ERROR', err);

                    return callback && callback();
        });

    }
}
