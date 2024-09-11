import './assets/main.css'

import { Quasar } from 'quasar'
import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'
// Import icon libraries
import '@quasar/extras/material-icons/material-icons.css'

// Import Quasar css
import 'quasar/src/css/index.sass'
const app = createApp(App)

app.use(Quasar,{
    plugins:{}
})
app.use(createPinia())
app.use(router)

app.mount('#app')
