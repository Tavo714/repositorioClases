import { Routes } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { SettingsComponent } from './components/settings/settings.component';
import { TeachersComponent } from './components/teachers/teachers.component';
import { TeacherCreateComponent } from './components/teacher-create/teacher-create.component';
import { TeacherEditComponent } from './components/teacher-edit/teacher-edit.component';


export const routes: Routes = [
    {
        path: 'dashboard',
        component: DashboardComponent
    },
    {
        path: 'teachers',
        component: TeachersComponent
    },
    {
        path: 'teachers/new',
        component: TeacherCreateComponent
    },
    {
        path: 'teachers/:id',
        component: TeacherEditComponent
    },
    {
        path: 'settings',
        component: SettingsComponent
    }
];
