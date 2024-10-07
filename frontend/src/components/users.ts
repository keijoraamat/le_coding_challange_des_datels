import { customElement } from '@aurelia/runtime-html';
import { User } from '../models/user';
import { UserController } from '../controllers/user-controller';

@customElement({
  name: 'users',
  template: `
    <template>
      <h2>User List</h2>
      <ul>
        <li repeat.for="user of users">
          \${user.name}
        </li>
      </ul>
    </template>
  `
})
export class Users {
  users: User[] = [];
  private userController: UserController;

  constructor() {
    this.userController = new UserController();
    this.loadUsers();
  }

  async loadUsers(): Promise<void> {
    this.users = await this.userController.getUsers();
  }
}
