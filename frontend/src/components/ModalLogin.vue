<template>
    <transition name="modal">
        <div class="modal-mask">
            <div class="modal-wrapper">
                <div class="modal-container">

                    <div class="login-wrapper border border-light">
                        <form class="form-signin" v-on:submit.prevent="login">
                            <h2 class="form-signin-heading">Please sign in</h2>
                            <div class="alert alert-danger" v-if="error">{{ error }}</div>
                            <label for="inputEmail" class="sr-only">User</label>
                            <input v-model="user" type="text" id="inputEmail" class="form-control" placeholder="User"
                                   required autofocus>
                            <label for="inputPassword" class="sr-only">Password</label>
                            <input v-model="password" type="password" id="inputPassword" class="form-control"
                                   placeholder="Password" required>
                            <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </transition>
</template>


<script>

import {AXIOS, tryInstallAuthToken, logout} from "../http-comons";

export default {
    name: 'Login',
    data () {
        return {
            user: '',
            password: '',
            error: false
        }
    },
    methods: {
        login() {

            AXIOS.post('/login', {username: this.user, password: this.password})
                .then(resp => this.loginSuccessful(resp))
                .catch(() => this.loginFailed())

        },
        loginSuccessful(resp) {
            if (!tryInstallAuthToken(resp)) {
                this.loginFailed()
                return
            }

            this.error = false
            this.$emit('login-successful')
        },
        loginFailed() {
            this.error = 'Login failed!'
            logout()
        }
    }
}

</script>

<style>
    .modal-mask {
        position: fixed;
        z-index: 9998;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background-color: rgba(0, 0, 0, .5);
        display: table;
        transition: opacity .3s ease;
    }

    .modal-wrapper {
        display: table-cell;
        vertical-align: middle;
    }

    .modal-container {
        width: 300px;
        margin: 0px auto;
        padding: 20px 30px;
        background-color: #fff;
        border-radius: 2px;
        box-shadow: 0 2px 8px rgba(0, 0, 0, .33);
        transition: all .3s ease;
        font-family: Helvetica, Arial, sans-serif;
    }

    .modal-header h3 {
        margin-top: 0;
        color: #42b983;
    }

    .modal-body {
        margin: 20px 0;
    }

    .modal-default-button {
        float: right;
    }

    /*
     * The following styles are auto-applied to elements with
     * transition="modal" when their visibility is toggled
     * by Vue.js.
     *
     * You can easily play with the modal transition by editing
     * these styles.
     */

    .modal-enter {
        opacity: 0;
    }

    .modal-leave-active {
        opacity: 0;
    }

    .modal-enter .modal-container,
    .modal-leave-active .modal-container {
        -webkit-transform: scale(1.2);
        transform: scale(1.2);
    }
</style>