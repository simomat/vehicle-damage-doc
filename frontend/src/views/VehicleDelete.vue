<template>
    <section>
        <h2>Delete vehicle {{ vehicle.identifizierungsnummer }}</h2>
        <form v-on:submit="delete_Vehicle">
            <p>The action cannot be undone.</p>
            <button type="submit" class="btn btn-danger">Delete</button>
            <router-link to="/list" class="btn btn-default">Cancel</router-link>
        </form>
    </section>
</template>

<script>

import {findVehicle, findVehicleKey, deleteVehicle} from "../vehicles";

export default {
    name: 'VehicleDelete',
    data: function () {
        return {vehicle: findVehicle(this.$route.params.fin)};
    },
    methods: {
        delete_Vehicle: function () {
            deleteVehicle(findVehicleKey(this.$route.params.fin))
            this.$router.push('/list');
        }
    }
}
</script>
