import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  private readonly USER_KEY = 'user';

  constructor() {}
  saveUser(user: any): void {
    if (!user) {
      throw new Error('LoginService: saveUser() - user is null or undefined');
    }

    try {
      localStorage.setItem(this.USER_KEY, JSON.stringify(user));
    } catch (error) {
      console.error('LoginService: saveUser() - error saving user', error);
      throw error;
    }

}
}
