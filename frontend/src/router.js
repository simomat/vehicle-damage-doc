import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/views/Login'
import VehicleList from '@/views/VehicleList';
import VehicleDelete from "./views/VehicleDelete";
import Vehicle from "./views/Vehicle";
import VehicleAddEdit from "./views/VehicleAddEdit";

Vue.use(Router)


export default new Router({
    routes: [
        {
            path: '/',
            name: 'login',
            component: Login
        },
        {
            path: '/list',
            name: 'list',
            component: VehicleList
        },
        {
            path: '/vehicle/:fin',
            name: 'vehicle',
            component: Vehicle
        },
        {
            path: '/vehicle/:method/:fin',
            name: 'vehicle-add-edit',
            component: VehicleAddEdit
        },
        {
            path: '/vehicle/:fin/delete',
            name: 'vehicle-delete',
            component: VehicleDelete
        }
    ]
});
