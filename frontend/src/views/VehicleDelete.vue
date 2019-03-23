<template>
    <section>
        <h2>Delete vehicle {{ vehicle.identifizierungsnummer }}</h2>
        <form v-on:submit="deleteVehicle">
            <p>The action cannot be undone.</p>
            <button type="submit" class="btn btn-danger">Delete</button>
            <router-link to="/list" class="btn btn-default">Cancel</router-link>
        </form>
    </section>
</template>

<script>

import {AXIOS} from "../http-comons"
import {handleAxiosError} from "../error-handlers";

export default {
    name: 'VehicleDelete',
    data: function () {
        return {
            vehicle: {}
        };
    },
    methods: {
        deleteVehicle: function () {
            AXIOS.delete(`/api/v1/vehicle/${this.$route.params.fin}`)
                .then(() => this.$router.push('/list'))
                .catch(error =>
                    handleAxiosError(error, {
                        notAuthorized: () => this.$emit('http-not-authorized', this.updateVehicles),
                        printableError: message => this.$emit('printable-error', message)
                    }))
        }
    },
    created() {
        AXIOS.get(`/api/v1/vehicle/${this.$route.params.fin}`)
            .then(resp  => this.vehicle = resp.data)
            .catch(error =>
                handleAxiosError(error, {
                    notAuthorized: () => this.$emit('http-not-authorized', this.updateVehicles),
                    printableError: message => this.$emit('printable-error', message)
                }))
    }
}
</script>
