
//百度地图获取城市名称的方法
let getCurrentCityName = function () {
    return new Promise(function (resolve) {
        let myCity = new window.BMap.LocalCity()
        myCity.get(function (result) {
            resolve(result.name)
        })
    })
}
export default getCurrentCityName