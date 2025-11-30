import { Component } from '@angular/core';
import { Routes } from '@angular/router';
import { PrimeiroComponente } from './components/primeiro-componente/primeiro-componente';
import { Home } from './components/home/home';

export const routes: Routes = [
  {path: '', component: Home},
  {path:'ola', component: PrimeiroComponente}
];
