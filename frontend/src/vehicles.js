// export const products = [
//     {id: 1, name: 'Angular', description: 'Superheroic JavaScript MVW Framework.', price: 100},
//     {id: 2, name: 'Ember', description: 'A framework for creating ambitious web applications.', price: 100},
//     {id: 3, name: 'React', description: 'A JavaScript Library for building user interfaces.', price: 100}
// ];

const vehicles = [
    {identifizierungsnummer: '1', marke: 'BMW', typvarianteversion: {typ: 'Kombi'}},
    {identifizierungsnummer: '2', marke: 'Audi', typvarianteversion: {typ: 'Limo'}},
    {identifizierungsnummer: '3', marke: 'Skoda', typvarianteversion: {typ: 'SUV'}}
];

export const findVehicle = function(fin) {
    return vehicles[findVehicleKey(fin)];
}

export const findVehicleKey = function (fin) {
    for (let key = 0; key < vehicles.length; key++) {
        if (vehicles[key].identifizierungsnummer === fin) {
            return key;
        }
    }
}

export const getVehicles = function () {
    return vehicles;
}

export function updateVehicle(key, vehicle) {
    vehicles[key] = vehicle
}

export function deleteVehicle(key) {
    vehicles.splice(key, 1);
}
