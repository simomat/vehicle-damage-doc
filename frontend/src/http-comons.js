import axios from 'axios'

export const logout = function() {
    AXIOS.defaults.headers.authorization = undefined
    localStorage.httpAuthToken = undefined
}

const installAuthToken = function (token) {
    AXIOS.defaults.headers.authorization = token
    localStorage.httpAuthToken = token
}

export const AXIOS = axios.create({
    // baseURL: `/api/v1`,
    headers: {'Content-Type': 'application/json; charset=utf-8'},
    data: {} // https://github.com/axios/axios/issues/86
})


export const tryInstallAuthToken = function (response) {
    if (!response.headers.authorization) {
        logout()
        return false
    }

    installAuthToken(response.headers.authorization)
    return true
}

export const tryRestoreAuthToken = function () {
    if (!AXIOS.defaults.headers.authorization && localStorage.httpAuthToken) {
        AXIOS.defaults.headers.authorization = localStorage.httpAuthToken
    }
}

