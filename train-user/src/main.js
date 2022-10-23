import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import Vant from 'vant';
import 'vant/lib/index.css';
import { Lazyload,Collapse,CollapseItem, Toast } from 'vant';
import axios from 'axios'
import qs from 'qs'
import md5 from 'js-md5'
import BMap from 'vue-baidu-map'


Vue.use(BMap, {ak: 'Lyln3Ln9wDDwRvU6jhK8wPweg9Gku7nu'});
Vue.prototype.$md5 = md5;
Vue.prototype.$qs = qs
Vue.prototype.$axios = axios
// Vue.prototype.$axios.defaults.baseURL = 'http://localhost:8081/'
    //Lazyload 是 Vue 指令，使用前需要对指令进行注册
Vue.use(Lazyload)
Vue.use(Collapse);
Vue.use(CollapseItem);
Vue.use(Toast);
Vue.use(Vant);

Vue.config.productionTip = false
Vue.use(ElementUI);

new Vue({
    router,
    render: h => h(App)
}).$mount('#app')
