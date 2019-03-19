<template>
    <section>
        Fahrzeug-Identifizierungsnummer:
        <h2>{{ vehicle.identifizierungsnummer }}</h2>
        <b>Marke:</b>
        <div>{{ vehicle.marke }}</div>
        <b>Typ</b>
        <div>{{ vehicle.typvarianteversion.typ }}</div>
        <br/>
        <span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span>
        <router-link to="/list">Back to vehicle list</router-link>
    </section>
</template>

<script>

import {AXIOS} from "../http-comons"

export default {
    name: 'Vehicle',
    data: function () {
        return {
            vehicle: {}
        }
    },
    created() {
        AXIOS.get(`/api/v1/vehicle/${this.$route.params.fin}`)
            .then(resp => this.vehicle = resp.data)
            .catch(e => console.log("ERROR: \n" + JSON.stringify(e)))
    }
}

</script>