import axios from 'axios'

export const AXIOS = axios.create({
    // baseURL: `/api/v1`,
    headers: {'Content-Type': 'application/json; charset=utf-8'},
    data: {} // https://github.com/axios/axios/issues/86
})


export const tryInstallAuthToken = function (response) {
    if (!response.headers.authorization) {
        AXIOS.defaults.headers.authorization = undefined
        return false
    }

    AXIOS.defaults.headers.authorization = response.headers.authorization
    return true
}