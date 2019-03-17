<template>
    <section>
        <div class="actions">
            <router-link class="btn btn-default" :to="{path: '/addvehicle'}">
                <font-awesome-icon :icon="['far', 'plus-square']" />
                Fahrzeug Hinzufügen
            </router-link>
        </div>
        <div class="filters row">
            <div class="form-group col-sm-3">
                <label for="search-element">Fahrzeug-Identifizierungsnummer</label>
                <input v-model="searchKey" class="form-control" id="search-element" placeholder="🔍" requred/>
            </div>
        </div>
        <table class="table table-sm">
            <thead>
            <tr>
                <th>FIN</th>
                <th>Marke</th>
                <th>Typ</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="vehicle in filteredVehicles">
                <td>
                    <router-link :to="{name: 'vehicle', params: {fin: vehicle.identifizierungsnummer}}">{{ vehicle.identifizierungsnummer }}</router-link>
                </td>
                <td>{{ vehicle.marke }}</td>
                <td>
                    {{ vehicle.typvarianteversion.typ }}
                </td>
                <td class="btn-group">
                    <router-link class="btn btn-warning btn-sm" :to="{name: 'vehicle-edit', params: {fin: vehicle.identifizierungsnummer}}"><font-awesome-icon :icon="['far', 'edit']" /></router-link>
                    <router-link class="btn btn-danger btn-sm" :to="{name: 'vehicle-delete', params: {fin: vehicle.identifizierungsnummer}}"><font-awesome-icon :icon="['far', 'trash-alt']" /></router-link>
                </td>
            </tr>
            </tbody>
        </table>
    </section>
</template>

<script>

import {AXIOS} from "../http-comons";


export default {
    name: 'VehicleList',
    data: function () {
        return {
            vehicles: [],
            searchKey: ''
        };
    },
    computed: {
        filteredVehicles: function () {
            let self = this;

            if (!self.searchKey) {
                return self.vehicles
            }
            return self.vehicles.filter(function (vehicle) {
                return vehicle.identifizierungsnummer.indexOf(self.searchKey) !== -1
            })
        }
    },
    created() {
        AXIOS.get('/api/v1/vehicles')
            .then(vehicles  => this.vehicles = vehicles)
            .catch(e => console.log("ERROR: \n" + JSON.stringify(e)))
    }
}
</script>