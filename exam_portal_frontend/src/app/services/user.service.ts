import {Injectable} from '@angular/core';
import {User} from "../models/User";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import BASE_URL from "./Helper";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(private _http:HttpClient) {
  }

  public addUser(user: User):Observable<any> {
    return this._http.post(`${BASE_URL}/user`,user);
  }
}
