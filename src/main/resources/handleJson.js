const data=require("./bhd-cum-rap.json");
const fs=require('fs');
const newData=[];
data.forEach(item=>{
    delete item.danhSachRap;
    newData.push(item);
})
const jsonString=JSON.stringify(newData);
fs.writeFileSync("bhd-cum-rap.json",jsonString);
