<template>
    <section>
        <h2>Fahrzeug Bearbeiten</h2>
        <form v-on:submit="updateVehicle">
            <div class="form-group">
                <label for="edit-name">Fahrzeug-Identifizierungsnummer</label>
                <input class="form-control" id="edit-name" v-model="vehicle.identifikationsnummer" required/>
            </div>
            <div class="form-group">
                <label for="edit-description">Marke</label>
                <textarea class="form-control" id="edit-description" rows="3" v-model="vehicle.marke"></textarea>
            </div>
            <div class="form-group">
                <label for="edit-price">Typ</label>
                <input class="form-control" id="edit-price" v-model="vehicle.typvarianteversion.typ"/>
            </div>
            <button type="submit" class="btn btn-primary">Save</button>
            <router-link to="/list" class="btn btn-default">Cancel</router-link>
        </form>
    </section>
</template>

<script>
import {findVehicle, findVehicleKey, updateVehicle} from "../vehicles";

export default {
    name: 'VehicleEdit',
    data: function () {
        return {
            vehicle: findVehicle(this.$route.params.fin)
        };
    },
    methods: {
        updateVehicle: function () {
            let vehicle = {
                identifikationsnummer: this.vehicle.identifikationsnummer,
                marke: this.vehicle.marke,
                description: this.vehicle.typvarianteversion.typ
            };
            updateVehicle(findVehicleKey(vehicle.identifikationsnummer), vehicle)
            this.$router.push('/list');
        }
    }
}

</script>