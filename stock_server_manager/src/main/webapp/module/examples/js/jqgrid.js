function loadData() {
    var modularPath = "/" + ump.contextPath +"/app/data/jqgridExamples.json";
    var grid_selector = "#jqgridExamples-grid-table";
    var pager_selector = "#jqgridExamples-grid-pager";
    grid(grid_selector,pager_selector,{
        url:"/" + ump.contextPath +"/app/data/jqgridExamples.json",
        colNames:['序列','系统代码','系统名称','系统描述'],
        colModel:[
            {name:'id',index:'id', width:60, sorttype:"string", editable: false,hidden: true },
            {name:'businessCode',index:'businessCode',width:90, editable:true, sorttype:"string",
                editrules:{
                    required:true
                },
                editoptions:{
                    readonly:true
                }
            },
            {name:'businessName',index:'businessName', width:150,editable: true,
                editrules:{
                    required:true
                }
            },
            {name:'description',index:'description', width:250, editable: true,edittype:"textarea"}
        ],
        caption: "jqgirdExamples"
    });
    gridPager(grid_selector,pager_selector,{
        editAction:{url:modularPath.edit},
        addAction:{url:modularPath.add},
        deleteAction:{url:modularPath.deleteUrl}
    });
}

loadData();