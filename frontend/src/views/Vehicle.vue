<template>
    <section>
        <div class="alert alert-danger" v-if="error">{{ error }}</div>
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
import {handleAxiosError} from "../error-handlers";

export default {
    name: 'Vehicle',
    data: function () {
        return {
            vehicle: {},
            error: ''
        }
    },
    created() {
        AXIOS.get(`/api/v1/vehicle/${this.$route.params.fin}`)
            .then(resp => this.vehicle = resp.data)
            .catch(error =>
                handleAxiosError(error, {
                    notAuthorized: () => this.$emit('http-not-authorized', this.updateVehicles),
                    printableError: message => this.$emit('printable-error', message)
                }))
    }
}

</script>