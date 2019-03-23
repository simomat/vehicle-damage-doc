

let call = (fun, param) => {
    if (fun) {
        fun(param)
    }
}

export const handleAxiosError = function (error, params) {
    if (error.response && error.response.status == 403) {
        call(params.notAuthorized)
    } else {
        call(params.printableError, JSON.stringify(error))
    }

}