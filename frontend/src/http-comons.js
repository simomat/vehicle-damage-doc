import axios from 'axios'

export const AXIOS = axios.create({
    // baseURL: `/api/v1`,
})


export const tryInstallAuthToken = function (response) {
    if (!response.headers.authorization) {
        AXIOS.defaults.headers.authorization = undefined
        return false
    }

    AXIOS.defaults.headers.authorization = response.headers.authorization
    return true
}