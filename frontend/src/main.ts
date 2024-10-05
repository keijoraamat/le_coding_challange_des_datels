import Aurelia from 'aurelia';
import { MyApp } from './my-app';
import { RouterConfiguration } from '@aurelia/router';

Aurelia
  .register(RouterConfiguration) // Register the router
  .app(MyApp) // Set the root component
  .start();
