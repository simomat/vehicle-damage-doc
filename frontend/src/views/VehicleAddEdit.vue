<template>
    <section class="text-left">
        <h2 v-if="$route.params.method === 'add'">Fahrzeug Hinzufügen</h2>
        <h2 v-if="$route.params.method === 'edit'">Fahrzeug Bearbeiten</h2>
        <form v-on:submit.prevent="createOrSaveVehicle">

            <div class="form-group border rounded p-3">
                <label for="identifizierungsnummer">Fahrzeug-Identifizierungsnummer</label>
                <div><input class="form-control" type="text" pattern="([A-HJ-NPR-Z1-9][A-HJ-NPR-Z\d][A-HJ-NPR-Z\d])([A-HJ-NPR-Z\d]{5})(\d)([A-HJ-NPR-Z\d]{8})" v-model="vehicle.identifizierungsnummer" id="Identifizierungsnummer" :disabled="$route.params.method === 'edit'"></div>
            </div>

            <div class="form-group border rounded p-3">
                <label for="erstzulassung">Datum der Erstzulassung des Fahrzeugs</label>
                <div><input class="form-control" type="date" v-model="vehicle.erstzulassung" id="erstzulassung"></div>
            </div>

            <div class="form-group border rounded p-3">
                <label class="form-text" for="fahrzeugklasse-options">Fahrzeugklasse</label>
                <div class="form-check form-check-inline " id="fahrzeugklasse-options">
                    <div v-for="klasse in fahrzeugklassen_values" :key="klasse" class="ml-3 mr-3">
                        <input class="form-check-input" type="radio" name="fahrzeugklasse" :value="klasse" v-model="vehicle.fahrzeugklasse">
                        <label class="form-check-label">{{ klasse }}</label>
                    </div>
                </div>
            </div>

            <div class="form-group border rounded p-3">
                <label for="marke">Marke</label>
                <div><input class="form-control" type="text" pattern=".{1,25}" v-model="vehicle.marke" id="marke"></div>
            </div>


            <div class="form-group border rounded p-3">
                <label for="typvarianteversion">Typ/ Variante/ Version</label>
                <div id="typvarianteversion">
                    <input class="form-control" type="text" pattern=".{1,25}" v-model="vehicle.typvarianteversion.typ">
                    <input class="form-control" type="text" pattern=".{1,25}" v-model="vehicle.typvarianteversion.variante">
                    <input class="form-control" type="text" pattern=".{1,25}" v-model="vehicle.typvarianteversion.version">
                </div>
            </div>

            <div class="form-group border rounded p-3">
                <label for="handelsbezeichnungen">Handelsbezeichnungen</label>
                <div><input class="form-control" type="text" pattern=".{1,25}" v-model="vehicle.handelsbezeichnungen" id="handelsbezeichnungen"></div>
            </div>

            <div class="form-group border rounded p-3">
                <label for="herstellerkurzbezeichnung">Hersteller-Kurzbezeichnung</label>
                <div><input class="form-control" type="text" pattern=".{1,25}" v-model="vehicle.herstellerkurzbezeichnung" id="herstellerkurzbezeichnung"></div>
            </div>


            <div class="form-group border rounded p-3">
                <label for="bezeichnungfahrzeugklasse">Bezeichnung der Fahrzeugklasse und des Aufbaus</label>
                <div><input class="form-control" type="text" pattern=".{1,25}" v-model="vehicle.bezeichnungfahrzeugklasse" id="bezeichnungfahrzeugklasse"></div>
            </div>

            <div class="form-group border rounded p-3">
                <label for="schadstoffklasse">Für die EG-Typgenehmigung maßgebliche Schadstoffklasse</label>
                <div><input class="form-control" type="text" pattern="\d{2}([A-Z][0A-LXYZ])?" v-model="vehicle.schadstoffklasse" id="schadstoffklasse"></div>
            </div>

            <div class="form-group border rounded p-3">
                <label for="emissionsklasse">Bezeichnung der nationalen Emissionsklasse</label>
                <div>
                    <select class="form-control" id="emissionsklasse" v-model="vehicle.emissionsklasse">
                        <option v-for="label in emissionsklasse_values" :key="label">{{ label }}</option>
                    </select>
                </div>
            </div>

            <div class="form-group border rounded p-3">
                <label for="kraftstoff">Kraftstoffart oder Energiequelle</label>
                <div>
                    <select class="form-control" v-model="vehicle.kraftstoff" id="kraftstoff">
                        <option v-for="(label, code) in kraftstoff_values" :value="code" :key="code">{{ label }}</option>
                    </select>
                </div>
            </div>

            <div class="form-group border rounded p-3">
                <label for="kraftstoffcode">Code zur Kraftstoffart oder Energiequelle</label>
                <div><input class="form-control" type="text" v-model="vehicle.kraftstoff" id="kraftstoffcode" disabled></div>
            </div>

            <button v-if="$route.params.method === 'add'" type="submit" class="btn btn-primary">Create</button>
            <button v-if="$route.params.method === 'edit'" type="submit" class="btn btn-primary">Save</button>
            <router-link class="btn btn-default" :to="{name: 'list'}">Cancel</router-link>
        </form>
    </section>
</template>

<script>

import {AXIOS} from "../http-comons"
import {handleAxiosError} from "../error-handlers";

export default {
    name: 'VehicleAdd',
    data: function () {
        return {
            fahrzeugklassen_values: [
                'A', 'B', 'C', 'D', 'E', 'F', 'S', 'M', 'J', 'sonstige'
            ],
            kraftstoff_values: {
                '0001': 'Benzin',
                '0002': 'Diesel',
                '0003': 'Vielstoff',
                '0004': 'reines Elektrofahrzeug',
                '0005': 'Flüssiggas (LPG) - Autogas, Gasfahrzeug',
                '0006': 'bivalenter Betrieb mit Benzin oder Flüssiggas (LPG) - Autogas, Gasfahrzeug',
                '0007': 'bivalenter Betrieb mit Benzin oder komprimiertem Erdgas (CNG) - Gasfahrzeug',
                '0008': 'kombinierter Betrieb mit Benzin und Elektromotor - Hybridelektrokraftfahrzeug',
                '0009': 'Erdgas (NG)',
                '0010': 'kombinierter Betrieb mit Diesel und Elektromotor - Hybridelektrokraftfahrzeug',
                '0011': 'Wasserstoff - Wasserstoffantrieb in einem Verbrennungsmotor',
                '0012': 'kombinierter Betrieb mit Wasserstoff und Elektromotor',
                '0013': 'bivalenter Betrieb mit Wasserstoff oder Benzin',
                '0014': 'bivalenter Betrieb mit Wasserstoff oder Benzin kombiniert mit Elektromotor',
                '0015': 'Brennstoffzelle mit Primärenergie Wasserstoff - Brennstoffzellenfahrzeug',
                '0016': 'Brennstoffzelle mit Primärenergie Benzin',
                '0017': 'Brennstoffzelle mit Primärenergie Methanol - Direktmethanolbrennstoffzelle',
                '0018': 'Brennstoffzelle mit Primärenergie Ethanol',
                '0019': 'kombinierter Betrieb mit Vielstoff- und Elektromotor',
                '0020': 'Methan (Biogas)',
                '0021': 'bivalenter Betrieb mit Benzin oder Methan',
                '0022': 'kombinierter Betrieb mit Erdgas und Elektromotor',
                '0023': 'Benzin/Ethanol (hierunter ist ein Kraftstoffgemisch zu verstehen wie z. B. E85) -- Ethanol-Kraftstoff',
                '0024': 'kombinierter Betrieb mit Flüssiggas (LPG) und Elektromotor',
                '0025': 'Hybridantrieb mit Benzin und extern aufladbarem elektrischen Speicher (Plug-in-Hybrid)',
                '0026': 'Hybridantrieb mit Diesel und extern aufladbarem elektrischen Speicher (Plug-in-Hybrid)',
                '0027': 'Hybridantrieb mit Flüssiggas (LPG) und extern aufladbarem elektrischen Speicher (Plug-in-Hybrid)',
                '0028': 'Hybridantrieb mit Wasserstoff und extern aufladbarem elektrischen Speicher (Plug-in-Hybrid)',
                '0029': 'Hybridantrieb mit Vielstoff und extern aufladbarem elektrischen Speicher (Plug-in-Hybrid)',
                '0030': 'Hybridantrieb mit Erdgas (NG) und extern aufladbarem elektrischen Speicher (Plug-in-Hybrid)',
                '0031': 'Hybridantrieb mit bivalentem Betrieb mit Wasserstoff oder Benzin und ext. aufladb. elektr. Speicher (Plug-in-Hybrid)',
                '0032': 'Wasserstoff/Erdgas (hierunter ist ein Kraftstoffgemisch zu verstehen)',
                '0033': 'Hybridantrieb mit Wasserstoff/Erdgas und extern aufladbarem elektrische Speicher (Plug-in-Hybrid)',
                '0034': 'Ethanol (hierunter ist auch ein Kraftstoffgemisch zu verstehen, dem neben Ethanol noch andere Kraftstoffe - ausgenommen Benzin (s. Code 0023)-oder Additive',
                '0035': 'Hybridantrieb mit Brennstoffzelle (Elektromotor) und Wasserstoff (Verbrennungsmotor) (Arbeitsverfahren NOVC-FCHV)',
                '0036': 'Hybridantrieb mit Brennstoffzelle (Elektromotor) und Wasserstoff (Verbrennungsmotor) sowie extern aufladbarem elektrischen Speicher'
            },
            emissionsklasse_values: ['EURO 1', 'EURO 2', 'EURO 3', 'EURO 4', 'EURO 5', 'EURO 6'],
            vehicle: {
                erstzulassung: '',
                fahrzeugklasse: '',
                identifizierungsnummer: '',
                marke: '',
                typvarianteversion: {
                    typ: '',
                    variante: '',
                    version: ''
                },
                handelsbezeichnungen: '',
                bezeichnungfahrzeugklasse: '',
                schadstoffklasse: '',
                emissionsklasse: '',
                kraftstoff: ''
            }
        }
    },
    methods: {
        createOrSaveVehicle: function() {
            let method = undefined
            if (this.$route.params.method === 'add') {
                method = 'post'
            } else if (this.$route.params.method === 'edit') {
                method = 'put'
            } else {
                throw 'unknown method'
            }

            AXIOS({
                method: method,
                url: '/api/v1/vehicle',
                data: this.vehicle})
                .then(() => this.$router.push('/list'))
                .catch(error =>
                    handleAxiosError(error, {
                        notAuthorized: () => this.$emit('http-not-authorized', this.updateVehicles),
                        printableError: message => this.$emit('printable-error', message)
                    }))
        }
    },
    created() {
        if (this.$route.params.method === 'edit') {
            AXIOS.get(`/api/v1/vehicle/${this.$route.params.fin}`)
                .then(resp  => this.vehicle = resp.data)
                .catch(error =>
                    handleAxiosError(error, {
                        notAuthorized: () => this.$emit('http-not-authorized', this.updateVehicles),
                        printableError: message => this.$emit('printable-error', message)
                    }))
        }
    }
}
</script>
