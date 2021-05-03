
var category = {
    list: [{
            id: 1,
            name: "일상",
            child: [{
                id: 1,
                name: "일기장",
                child: {}
            }]
        },
        {
            id: 2,
            name: "개발",
            child: [{
                id: 1,
                name: "웹",
                child: [{
                    id: 1,
                    name: "프론트엔드",
                    child: []
                }, {
                    id: 2,
                    name: "백엔드",
                    child: [{
                        id :1,
                        name : "NodeJs",
                        child :[]
                    },{
                        id :2,
                        name : "Spring",
                        child : []
                    }]
                }],
            }, {
                id: 2,
                name: "하드웨어",
                child: []
            }]

        },
        {
            id: 3,
            name: "사진첩",
            child: [{
                id: 1,
                name: "여행",
                child: {}
            }]
        },
    ]
}

// console.log(category.list)




function rec(items){

    for(var item of items){
        console.log(item)
    }

}

rec(category.list);

