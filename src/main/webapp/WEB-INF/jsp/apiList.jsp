<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->


<head>
    <meta charset="utf-8"/>
    <title>Simple Search Application</title>
    <link href='https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Material+Icons' rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/vuetify/dist/vuetify.min.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, minimal-ui">

    <link rel="stylesheet" href="https://unpkg.com/vue-multiselect@2.1.0/dist/vue-multiselect.min.css">


</head>
<body>
<div id="app" style="visibility: hidden">
    <v-app id="inspire">

        <v-toolbar color="green" dark fixed app>
            <%--<v-toolbar-side-icon @click.stop="drawer = !drawer"></v-toolbar-side-icon>--%>
            <v-toolbar-title style="padding-left: 20px">Simple Search Application</v-toolbar-title>
        </v-toolbar>

        <v-content>
            <v-app id="inspire">





                <div>
                        <h2 style="text-align: center; padding-bottom: 20px;padding-top: 10px"><u><b>API LIST</b></u></h2>
                    <p style="margin-left: 20%;" ><b>1. Create developer(<i>&lt;base url&gt;/createdeveloper/{email}</i>), POST Request</b></p>
                    <br/><p style="margin-left: 20%;"><br/>Request - <br/>
                    &nbsp;&nbsp;&nbsp;&nbsp; /createdeveloper </p><br/>
                    <p style="margin-left: 20%;"><code>
                        {

                        "email": "test_mail@gmail.com",

                        }
                </code></p>
                    <p style="margin-left: 20%;">Response -<br/>
                        <code>
                    {
                        id: 1,
                        email: "test_mail@gmail.com",
                        languageEntities: [ ],
                        programmingLanguageEntities:[]
                    }
                        </code>
                    </p>
                    <br/>
                    <br/>



                    <p style="margin-left: 20%;" ><b>2. Update developer(<i>&lt;base url&gt;/updatedeveloper</i>), PUT Request</b></p>
                        <br/><p style="margin-left: 20%;"><br/>Request - <br/>
                        &nbsp;&nbsp;&nbsp;&nbsp; /updatedeveloper </p><br/>
                        <p style="margin-left: 20%;"><code>
                            {
                              "id": 3,
                              "email": "updated_mail@signet.com",

                            }
                        </code></p>
                        <p style="margin-left: 20%;">Response -<br/>
                            <code>
                        {
                            id: 1,
                            email: "updated_mail@signet.com",
                            languageEntities: [ ],
                            programmingLanguageEntities: [
                            {
                            id: 12,
                            name: "ruby"
                            }
                            ]
                        }
                            </code>
                        </p>

                        <br/>
                        <br/>
                    <p style="margin-left: 20%;" ><b>3. Delete a developer(<i>&lt;base url&gt;/deletedeveloper/{id}</i>), GET Request</b></p>
                        <br/><p style="margin-left: 20%;"><br/>Request - <br/>
                        &nbsp;&nbsp;&nbsp;&nbsp;  /deletedeveloper/5 </p><br/>
                        <p style="margin-left:20%">Response - </p>
                        <p style="margin-left:20%"><code>
                            return all developers list after deleting the developer with id 5
                        </code></p>


                    <p style="margin-left: 20%;" ><b>4. Get all developer (<i>&lt;base url&gt;/getalldeveloper</i>)</b> </p>
                        <br/><p style="margin-left: 20%;"><br/>Request - <br/>
                        &nbsp;&nbsp;&nbsp;&nbsp;  /getalldeveloper </p><br/>
                        <p style="margin-left:20%">Response - </p>
                        <div style="overflow-y: scroll; height:400px;margin-left:12%">
                            <p style="margin-left: 20%;"><code id="json"></code></p>
                        </div>


                        <br/><br/>

                    <p style="margin-left: 20%;" ><b>5. Get developer by developer id(<i>&lt;base url&gt;/getdeveloperbyid/{id}</i>), GET Request</b></p>
                    <br/><p style="margin-left: 20%;">
                    <br/>Request - <br/>
                    &nbsp;&nbsp;&nbsp;&nbsp; /getdeveloperbyid/1
                    <br/>
                    Response -
                </p><br/>
                    <p style="margin-left: 20%;"><code>
                        {
                        id: 1,
                        email: "test_mail@gmail.com",
                        languageEntities: [ ],
                        programmingLanguageEntities: [
                        {
                        id: 12,
                        name: "ruby"
                        }
                        ]
                        }
                    </code></p>

                    <br/>
                    <br/>
                    <p style="margin-left: 20%;" ><b>6. Get developer by developer email(<i>&lt;base url&gt;/getdeveloperbyemail/{email}</i>), GET Request </b></p>
                    <br/><p style="margin-left: 20%;"> <br/>Request - <br/>
                    &nbsp;&nbsp;&nbsp;&nbsp; /getdeveloperbyemail/test_mail@gmail.com <br/>
                    Response -
                </p><br/>
                    <p style="margin-left: 20%;"><code>
                        {
                        id: 1,
                        email: "test_mail@gmail.com",
                        languageEntities: [ ],
                        programmingLanguageEntities: [
                        {
                        id: 12,
                        name: "ruby"
                        }
                        ]
                        }
                    </code></p>

                    <br/>
                    <br/>

                    <%--</v-card>--%>
                </div>


            </v-app>

        </v-content>

        <v-footer color="green" app inset>
            <span class="white--text">&copy; Developed By <a style="color:#99240b;"
                                                             href="https://www.linkedin.com/in/bishwajit-saha-2b5493147/">Bishwajit Saha</a> </span>
        </v-footer>
    </v-app>
</div>

<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vuetify/dist/vuetify.js"></script>
<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>--%>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script src="https://unpkg.com/vue-multiselect@2.1.0"></script>

<script>
    new Vue({
        el: '#app',
        components: {
            Multiselect: window.VueMultiselect.default
        },
        data: {
            drawer: null,
            search: '',
            headers: [
                {text: 'email', value: 'calories'},
                {text: 'programming_languages', value: 'fat'},
                {text: 'languages', value: 'carbs'},
            ],
            desserts: [
                {
                    value: false,
                    name: 'Frozen Yogurt',
                    calories: 159,
                    fat: 6.0,
                    carbs: 24,
                    protein: 4.0,
                    iron: '1%'
                },
                {
                    value: false,
                    name: 'Ice cream sandwich',
                    calories: 237,
                    fat: 9.0,
                    carbs: 37,
                    protein: 4.3,
                    iron: '1%'
                },
                {
                    value: false,
                    name: 'Eclair',
                    calories: 262,
                    fat: 16.0,
                    carbs: 23,
                    protein: 6.0,
                    iron: '7%'
                },
                {
                    value: false,
                    name: 'Cupcake',
                    calories: 305,
                    fat: 3.7,
                    carbs: 67,
                    protein: 4.3,
                    iron: '8%'
                },
                {
                    value: false,
                    name: 'Gingerbread',
                    calories: 356,
                    fat: 16.0,
                    carbs: 49,
                    protein: 3.9,
                    iron: '16%'
                },
                {
                    value: false,
                    name: 'Jelly bean',
                    calories: 375,
                    fat: 0.0,
                    carbs: 94,
                    protein: 0.0,
                    iron: '0%'
                },
                {
                    value: false,
                    name: 'Lollipop',
                    calories: 392,
                    fat: 0.2,
                    carbs: 98,
                    protein: 0,
                    iron: '2%'
                },
                {
                    value: false,
                    name: 'Honeycomb',
                    calories: 408,
                    fat: 3.2,
                    carbs: 87,
                    protein: 6.5,
                    iron: '45%'
                },
                {
                    value: false,
                    name: 'Donut',
                    calories: 452,
                    fat: 25.0,
                    carbs: 51,
                    protein: 4.9,
                    iron: '22%'
                },
                {
                    value: false,
                    name: 'KitKat',
                    calories: 518,
                    fat: 26.0,
                    carbs: 65,
                    protein: 7,
                    iron: '6%'
                }
            ],
            loading: false,
            eloading: false,
            lloading: false,
            plloading: false,
            items: [],
            emailitems: [],
            plitems: [],
            litems: [],
            searchEmail: null,
            searchProgrammingLanguage: null,
            searchProgrammingLanguage2: null,
            searchLanguage: null,
            select: null,
            selectEmail: null,
            selectProgrammingLanguage: null,
            selectProgrammingLanguage2: null,
            selectLanguage: null,
            states: [
                'Alabama',
                'Alaska',
                'American Samoa',
                'Arizona',
                'Arkansas',
                'California',
                'Colorado',
                'Connecticut',
                'Delaware',
                'District of Columbia',
                'Federated States of Micronesia',
                'Florida',
                'Georgia',
                'Guam',
                'Hawaii',
                'Idaho',
                'Illinois',
                'Indiana',
                'Iowa',
                'Kansas',
                'Kentucky',
                'Louisiana',
                'Maine',
                'Marshall Islands',
                'Maryland',
                'Massachusetts',
                'Michigan',
                'Minnesota',
                'Mississippi',
                'Missouri',
                'Montana',
                'Nebraska',
                'Nevada',
                'New Hampshire',
                'New Jersey',
                'New Mexico',
                'New York',
                'North Carolina',
                'North Dakota',
                'Northern Mariana Islands',
                'Ohio',
                'Oklahoma',
                'Oregon',
                'Palau',
                'Pennsylvania',
                'Puerto Rico',
                'Rhode Island',
                'South Carolina',
                'South Dakota',
                'Tennessee',
                'Texas',
                'Utah',
                'Vermont',
                'Virgin Island',
                'Virginia',
                'Washington',
                'West Virginia',
                'Wisconsin',
                'Wyoming'
            ],
            emails: [],
            programmingLanguages: [],
            languages: [],
            tableItems: [],


            value: [],
            options: [
                {name: 'Vue.js', language: 'JavaScript'},
                {name: 'Adonis', language: 'JavaScript'},
                {name: 'Rails', language: 'Ruby'},
                {name: 'Sinatra', language: 'Ruby'},
                {name: 'Laravel', language: 'PHP'},
                {name: 'Phoenix', language: 'Elixir'}
            ],


            //    added for crud operation
            dialog: false,
            cheaders: [
                {
                    text: 'Interview Score',
                    align: 'left',
                    sortable: true,
                    value: 'score'
                },
                {
                    text: 'Comment',
                    align: 'left',
                    sortable: true,
                    value: 'comment'
                },
                // { text: 'Calories', value: 'calories' },
                // { text: 'Fat (g)', value: 'fat' },
                // { text: 'Carbs (g)', value: 'carbs' },
                // { text: 'Protein (g)', value: 'protein' },
                // { text: 'Actions', value: 'name', sortable: false }
            ],
            desserts: [],
            editedIndex: -1,
            editedItem: {
                name: '',
                calories: 0,
                fat: 0,
                carbs: 0,
                protein: 0
            },
            defaultItem: {
                name: '',
                calories: 0,
                fat: 0,
                carbs: 0,
                protein: 0
            },


        },

        methods: {


            getAllDeveloper() {
                axios.get('<%=request.getContextPath()%>/getalldeveloper')
                    .then(result => {
                        document.getElementById("json").innerHTML = JSON.stringify(result.data, undefined, 2);



                    })
                    .catch(function (error) {
                    });
            },


            //    for crud -
            initialize() {
                this.desserts = [
                    {
                        name: 'Frozen Yogurt',
                        calories: 159,
                        fat: 6.0,
                        carbs: 24,
                        protein: 4.0
                    },
                    {
                        name: 'Ice cream sandwich',
                        calories: 237,
                        fat: 9.0,
                        carbs: 37,
                        protein: 4.3
                    },
                    {
                        name: 'Eclair',
                        calories: 262,
                        fat: 16.0,
                        carbs: 23,
                        protein: 6.0
                    },
                    {
                        name: 'Cupcake',
                        calories: 305,
                        fat: 3.7,
                        carbs: 67,
                        protein: 4.3
                    },
                    {
                        name: 'Gingerbread',
                        calories: 356,
                        fat: 16.0,
                        carbs: 49,
                        protein: 3.9
                    },
                    {
                        name: 'Jelly bean',
                        calories: 375,
                        fat: 0.0,
                        carbs: 94,
                        protein: 0.0
                    },
                    {
                        name: 'Lollipop',
                        calories: 392,
                        fat: 0.2,
                        carbs: 98,
                        protein: 0
                    },
                    {
                        name: 'Honeycomb',
                        calories: 408,
                        fat: 3.2,
                        carbs: 87,
                        protein: 6.5
                    },
                    {
                        name: 'Donut',
                        calories: 452,
                        fat: 25.0,
                        carbs: 51,
                        protein: 4.9
                    },
                    {
                        name: 'KitKat',
                        calories: 518,
                        fat: 26.0,
                        carbs: 65,
                        protein: 7
                    }
                ];

                axios.get('<%=request.getContextPath()%>/getinterview')
                    .then((response) => {
                        this.desserts = response.data;
                    })
                    .catch(function (error) {
                        console.log(error);
                    })
                    .then(function () {

                    });

            },

            editItem(item) {
                this.editedIndex = this.desserts.indexOf(item);
                this.editedItem = Object.assign({}, item);
                this.dialog = true
            },

            deleteItem(item) {

                const index = this.desserts.indexOf(item);
                if (confirm('Are you sure you want to delete this item?')) {
                    // this.desserts.splice(index, 1);

                    axios.get('<%=request.getContextPath()%>/deleteinterview/' + item.id)
                        .then((response) => {
                            this.initialize();
                            // this.searchAll();
                        })
                        .catch(function (error) {
                            // handle error
                            console.log(error);
                        })
                        .then(function () {
                            // always executed
                        });


                }
            },

            close() {
                this.dialog = false;
                setTimeout(() => {
                    this.editedItem = Object.assign({}, this.defaultItem)
                    this.editedIndex = -1
                }, 300)
            },

            save() {
                if (this.editedIndex > -1) {
                    axios.post('<%=request.getContextPath()%>/updateinterview', {
                        "id": this.editedItem.id,
                        "score": this.editedItem.score,
                        "comment": this.editedItem.comment,
                    })
                        .then(result => {
                            this.initialize();

                        })
                        .catch(function (error) {
                        });


                } else {
                    console.log('!! inter view add called!!');
                    var data = {
                        "name": this.editedItem,
                    };
                    console.log(JSON.stringify(data));

                    axios.post('<%=request.getContextPath()%>/createinterview', {"score": this.editedItem.score,"comment": this.editedItem.comment})
                        .then(result => {
                            this.initialize();

                        })
                        .catch(function (error) {
                        });
                    this.desserts.push(this.editedItem)
                }
                this.close()
            },

            getAllData() {
                axios.get('<%=request.getContextPath()%>/searchall')
                    .then((response) => {
                        this.tableItems = response.data;
                        document.getElementById('app').style.visibility = 'visible';
                    })
                    .catch(function (error) {

                        console.log(error);
                    })
                    .then(function () {
                    });
            },
            getAllpna() {
                axios.get('<%=request.getContextPath()%>/allpna')
                    .then((response) => {
                        this.tableItems = response.data;
                    })
                    .catch(function (error) {
                        console.log(error);
                    })
                    .then(function () {
                    });
            },

        },
        updated: function () {
            this.$nextTick(function () {
            })
        },
        computed: {
            formTitle() {
                return this.editedIndex === -1 ? 'New Item' : 'Edit Item'
            }
        },
        created() {
            this.initialize()
        },


        mounted: function () {
            axios.get('<%=request.getContextPath()%>/searchall')
                .then((response) => {
                    console.log(response);
                    this.tableItems = response.data;
                    document.getElementById('app').style.visibility = 'visible';

                    this.getAllDeveloper();
                })
                .catch(function (error) {

                    console.log(error);
                })
                .then(function () {
                });


        }
    })
</script>


</body>

</html>
