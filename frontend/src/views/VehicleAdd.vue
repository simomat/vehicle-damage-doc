<template>
    <section>
        <h2>Fahrzeug Hinzufügen</h2>
        <form v-on:submit="createVehicle">
            <div class="form-group">
                <label for="add-name">Fahrzeug-Identifizierungsnummer</label>
                <input class="form-control" id="add-name" v-model="vehicle.identifizierungsnummer" required/>
            </div>
            <div class="form-group">
                <label for="add-description">Marke</label>
                <textarea class="form-control" id="add-description" rows="10" v-model="vehicle.marke"></textarea>
            </div>
            <div class="form-group">
                <label for="add-price">Typ</label>
                <input type="number" class="form-control" id="add-price" v-model="vehicle.price"/>
            </div>
            <button type="submit" class="btn btn-primary">Create</button>
            <router-link class="btn btn-default" :to="{name: 'root'}">Cancel</router-link>
        </form>
    </section>
</template>

<script>
export default {
    name: 'VehicleAdd',
    data: function () {
        return {
            vehicle: {
                identifizierungsnummer: '',
                marke: '',
                typvarianteversion: {
                    typ: ''
                }
            }
        }
    },
    methods: {
        createVehicle: function() {
            let vehicle = this.vehicle;
            vehicle.push({
                identifizierungsnummer: vehicle.identifizierungsnummer,
                marke: vehicle.marke,
                typvarianteversion: vehicle.typvarianteversion
            });
            this.$router.push('/list');
        }
    }
}
</script>
