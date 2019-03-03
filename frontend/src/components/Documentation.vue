<template>
    <div class="container">
        <form v-on:submit.prevent="formSubmitted">
            <div class="form-group border-top">
                <label for="erstzulassung">B: Datum der Erstzulassung des Fahrzeugs</label>
                <div><input class="form-control" type="date" v-model="erstzulassung" id="erstzulassung"></div>
            </div>

            <div class="form-group border-top">
                <label class="form-text" for="fahrzeugklasse-options">J: Fahrzeugklasse</label>
                <div class="form-check form-check-inline " id="fahrzeugklasse-options">
                    <div v-for="klasse in fahrzeugklassen_values" :key="klasse" class="ml-3 mr-3">
                        <input class="form-check-input" type="radio" name="fahrzeugklasse" :value="klasse" v-model="fahrzeugklasse">
                        <label class="form-check-label">{{ klasse }}</label>
                    </div>
                </div>
            </div>

            <div class="form-group border-top">
                <label for="identifizierungsnummer">E: Fahrzeug-Identifizierungsnummer</label>
                <div><input class="form-control" type="text" pattern="([A-HJ-NPR-Z1-9][A-HJ-NPR-Z\d][A-HJ-NPR-Z\d])([A-HJ-NPR-Z\d]{5})(\d)([A-HJ-NPR-Z\d]{8})" v-model="identifizierungsnummer" id="Identifizierungsnummer"></div>
            </div>

            <div class="form-group border-top">
                <label for="marke">D.1: Marke</label>
                <div><input class="form-control" type="text" pattern=".{1,25}" v-model="marke" id="marke"></div>
            </div>

            <div class="form-group border-top">
                <label for="typvarianteversion">D.2: Typ/ Variante/ Version</label>
                <div id="typvarianteversion">
                    <input class="form-control" type="text" pattern=".{1,25}" v-model="typvarianteversion_typ">
                    <input class="form-control" type="text" pattern=".{1,25}" v-model="typvarianteversion_variante">
                    <input class="form-control" type="text" pattern=".{1,25}" v-model="typvarianteversion_version">
                </div>
            </div>

            <div class="form-group border-top">
                <label for="handelsbezeichnungen">D.3: Handelsbezeichnungen</label>
                <div><input class="form-control" type="text" pattern=".{1,25}" v-model="handelsbezeichnungen" id="handelsbezeichnungen"></div>
            </div>

            <div class="form-group border-top">
                <label for="herstellerkurzbezeichnung">2: Hersteller-Kurzbezeichnung</label>
                <div><input class="form-control" type="text" pattern=".{1,25}" v-model="herstellerkurzbezeichnung" id="herstellerkurzbezeichnung"></div>
            </div>

            <div class="form-group border-top">
                <label for="bezeichnungfahrzeugklasse">5: Bezeichnung der Fahrzeugklasse und des Aufbaus</label>
                <div><input class="form-control" type="text" pattern=".{1,25}" v-model="bezeichnungfahrzeugklasse" id="bezeichnungfahrzeugklasse"></div>
            </div>

            <div class="form-group border-top">
                <label for="schadstoffklasse">V.9 Für die EG-Typgenehmigung maßgebliche Schadstoffklasse</label>
                <div><input class="form-control" type="text" pattern="\d{2}([A-Z][0A-LXYZ])?" v-model="schadstoffklasse" id="schadstoffklasse"></div>
            </div>

            <div class="form-group border-top">
                <label for="emissionsklasse">14: Bezeichnung der nationalen Emissionsklasse</label>
                <div>
                    <select class="form-control" id="emissionsklasse" v-model="emissionsklasse">
                        <option>EURO 1</option>
                        <option>EURO 2</option>
                        <option>EURO 3</option>
                        <option>EURO 4</option>
                        <option>EURO 5</option>
                        <option>EURO 6</option>
                    </select>
                </div>
            </div>

            <div class="form-group border-top">
                <label for="kraftstoff">P.3: Kraftstoffart oder Energiequelle</label>
                <div>
                    <select class="form-control" v-model="kraftstoff" id="kraftstoff">
                        <option v-for="(label, code) in kraftstoff_values" :value="code" :key="code">{{ label }}</option>
                    </select>
                </div>
            </div>

            <div class="form-group border-top">
                <label for="kraftstoffcode">10:	Code zu P.3</label>
                <div><input class="form-control" type="text" v-model="kraftstoff" id="kraftstoffcode" disabled></div>
            </div>

            <button type="submit" class="btn btn-primary mb-2">Einsenden</button>
        </form>
    </div>
</template>

<script>

import {AXIOS} from "../http-comons";

export default {
    name: "Documentation",
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
            erstzulassung: '',
            fahrzeugklasse: '',
            identifizierungsnummer: '',
            marke: '',
            typvarianteversion_typ: '',
            typvarianteversion_variante: '',
            typvarianteversion_version: '',
            handelsbezeichnungen: '',
            herstellerkurzbezeichnung: '',
            bezeichnungfahrzeugklasse: '',
            schadstoffklasse: '',
            emissionsklasse: '',
            kraftstoff: ''
        }
    },
    methods: {
        formSubmitted: function () {

            console.log('POSTIIIING!')

            AXIOS.post(
                '/doku',
                {
                    erstzulassung: this.erstzulassung,
                    fahrzeugklasse: this.fahrzeugklasse,
                    identifizierungsnummer: this.identifizierungsnummer,
                    marke: this.marke,
                    typvarianteversion: {
                        typ: this.typvarianteversion_typ,
                        variante: this.typvarianteversion_variante,
                        version: this.typvarianteversion_version
                    },
                    handelsbezeichnungen: this.handelsbezeichnungen,
                    herstellerkurzbezeichnung: this.herstellerkurzbezeichnung,
                    bezeichnungfahrzeugklasse: this.bezeichnungfahrzeugklasse,
                    schadstoffklasse: this.schadstoffklasse,
                    emissionsklasse: this.emissionsklasse,
                    kraftstoff: this.kraftstoff

                }
            ).then(r => console.log("RESULT: \n" + JSON.stringify(r)))
                .catch(e => console.log("ERROR: \n" + JSON.stringify(e)));
        }
    }
}
</script>

<style scoped>

</style>