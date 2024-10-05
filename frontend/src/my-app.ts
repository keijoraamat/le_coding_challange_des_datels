import { IRouter } from '@aurelia/router';
import { customElement } from '@aurelia/runtime-html';

@customElement({
  name: 'my-app',
  template: `<template>
               <h1>Welcome to Aurelia 2!</h1>
               <nav>
                 <a load="users">Users</a>
               </nav>
               <au-viewport></au-viewport>
             </template>`
})
export class MyApp {
  constructor(private router: IRouter) {}

  static routes = [
    { path: 'users', component: import('./components/users'), title: 'Users' }
  ];
}
