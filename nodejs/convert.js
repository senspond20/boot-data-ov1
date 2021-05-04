
var str = '<ul>dfsdfdfs<ul>sfsfsdfs</ul>sdfsd</ul>';

var regEx = /<.*>(.*)<\/.*>/g

// console.log(regEx.test(str))
// console.log(regEx.exec(str)[1])
// console.log(RegExp.$1)
// console.log(RegExp.$2)

// var rep = regEx.exec(str)[1];
// console.log(rep)
// var newStr = str.replace(rep, '추가한다' + rep);
// console.log(newStr)


function createTag(tag){
    return `<${tag}></${tag}>`;
}
function appendToTag(otag, str){
    var regEx = /<.*>(.*)<\/.*>/g;
    var rep = regEx.exec(otag)[1];
    // console.log(rep)
    return otag.replace(rep, str + rep);
}

var ul = createTag('ul')
appendToTag(ul, '안녕하세요');

console.log(appendToTag(ul, '안녕하세요'))


class Tag{
    tag
    constructor(tag){
        this.tag = tag;
    }
}




