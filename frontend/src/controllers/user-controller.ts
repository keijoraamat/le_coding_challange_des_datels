import { HttpClient } from '@aurelia/fetch-client';
import { User } from '../models/user';

export class UserController {
  private httpClient: HttpClient;

  constructor() {
    this.httpClient = new HttpClient();
  }

  async getUsers(): Promise<User[]> {
    try {
        console.log('Fetching users');
      const response = await this.httpClient.fetch('http://localhost:8080/api/v2/users');
      const data = await response.json();
      console.log('Users:', data);
      return data.map((user: any) => new User(user.id, user.name, user.email));
    } catch (error) {
      console.error('Error fetching users:', error);
      return [];
    }
  }
}
