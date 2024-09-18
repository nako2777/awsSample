import './assets/main.css'

import { Quasar } from 'quasar'
import { createApp } from 'vue'
import { createPinia } from 'pinia'
// import Amplify from 'aws-amplify';
// import awsconfig from './aws-exports';
import App from './App.vue'
import router from './router'
// Import icon libraries
import '@quasar/extras/material-icons/material-icons.css'

// Import Quasar css
import 'quasar/src/css/index.sass'
const app = createApp(App)
// Amplify.configure(awsconfig);


app.use(Quasar,{
    plugins:{}
})
app.use(createPinia())
app.use(router)

app.mount('#app')
