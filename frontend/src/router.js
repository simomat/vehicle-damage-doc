import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/views/Login'
import VehicleList from '@/views/VehicleList';
import VehicleEdit from "./views/VehicleEdit";
import VehicleDelete from "./views/VehicleDelete";
import Vehicle from "./views/Vehicle";
import VehicleAdd from "./views/VehicleAdd";

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
            path: '/edit/:fin',
            name: 'vehicle-edit',
            component: VehicleEdit
        },
        {
            path: '/vehicle/:fin/delete',
            name: 'vehicle-delete',
            component: VehicleDelete
        },
        {
            path: '/addvehicle',
            name: 'vehicle-add',
            component: VehicleAdd
        }
    ]
});
