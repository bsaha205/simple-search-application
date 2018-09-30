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
            <v-toolbar-title style="padding-left: 20px">Simple Search Application</v-toolbar-title>
        </v-toolbar>
        <v-content>
            <v-app id="inspire">

                <v-toolbar
                        dark
                        color="#202083"
                >
                    <v-autocomplete
                            :loading="plloading"
                            :items="plitems"
                            :search-input.sync="searchProgrammingLanguage"
                            v-model="selectProgrammingLanguage"
                            cache-items
                            class="mx-3"
                            flat
                            hide-no-data
                            hide-details
                            label="Enter 1st Programming Language (Ex: C,ruby etc.)"
                            solo-inverted
                    ></v-autocomplete>

                    <v-autocomplete
                            :loading="plloading"
                            :items="plitems"
                            :search-input.sync="searchProgrammingLanguage2"
                            v-model="selectProgrammingLanguage2"
                            cache-items
                            class="mx-3"
                            flat
                            hide-no-data
                            hide-details
                            label="Enter 2nd Programming Language (Ex: C,ruby etc.)"
                            solo-inverted
                    ></v-autocomplete>

                    <v-autocomplete
                            :loading="lloading"
                            :items="litems"
                            :search-input.sync="searchLanguage"
                            v-model="selectLanguage"
                            cache-items
                            class="mx-3"
                            flat
                            hide-no-data
                            hide-details
                            label="Enter Language (Ex: en,jp etc.)"
                            solo-inverted
                    ></v-autocomplete>

                </v-toolbar>

                <div class="v-toolbar__content" style="height: 64px;">
                    <div class="v-toolbar__title"></div>
                    <hr class="mx-2 v-divider v-divider--inset v-divider--vertical theme--light">

                    <div class="v-dialog__container" style="display: inline-block;">
                        <div class="v-dialog__activator">
                            <button type="button" class="mb-2 v-btn theme--dark success" style="position: relative;">
                                <div @click="getAllpna" class="v-btn__content">Programming Languages That Are Not used</div>

                            </button>
                            <button type="button" onclick="location.href='<%=request.getContextPath()%>/apiList'" class="mb-2 v-btn theme--dark success" style="position: relative;">
                            <b>SHOW API LIST</b>
                            </button>

                        </div>
                    </div>
                </div>
                <v-card>
                </v-card>


                <v-card>
                    <v-card-title>
                    </v-card-title>
                    <v-data-table
                            :headers="headers"
                            :items="tableItems"
                            :search="search"
                    >
                        <template slot="items" slot-scope="props">
                            <td>{{ props.item.email }}</td>
                            <td>{{ props.item.programmingLanguage
                                }}
                            </td>
                            <td>{{ props.item.language
                                }}
                            </td>
                        </template>

                        <v-alert slot="no-results" :value="true" color="error" icon="warning">
                            Your search for "{{ search }}" found no results.
                        </v-alert>
                    </v-data-table>
                </v-card>
                <%--start crud--%>
                <div>
                    <v-toolbar flat color="white">
                        <v-toolbar-title>Developer Admin Panel(Interview)</v-toolbar-title>
                        <v-divider
                                class="mx-2"
                                inset
                                vertical
                        ></v-divider>

                        <v-dialog v-model="dialog" max-width="500px">
                            <v-btn slot="activator" color="success" dark class="mb-2">Add New</v-btn>
                            <v-card>
                                <v-card-title>
                                    <span class="headline">{{ formTitle }}</span>
                                </v-card-title>

                                <v-card-text>
                                    <v-container grid-list-md>
                                        <v-layout wrap>
                                            <v-flex xs12 sm6 md4>
                                                <v-text-field v-model="editedItem.score"
                                                              label="Score"></v-text-field>
                                                <v-text-field v-model="editedItem.comment"
                                                              label="Comment"></v-text-field>
                                            </v-flex>
                                        </v-layout>
                                    </v-container>
                                </v-card-text>

                                <v-card-actions>
                                    <v-spacer></v-spacer>
                                    <v-btn color="blue darken-1" flat @click.native="close">Cancel</v-btn>
                                    <v-btn color="blue darken-1" flat @click.native="save">Save</v-btn>
                                </v-card-actions>
                            </v-card>
                        </v-dialog>
                    </v-toolbar>
                    <v-data-table
                            :headers="cheaders"
                            :items="desserts"
                            hide-actions
                            class="elevation-1"
                    >
                        <template slot="items" slot-scope="props">
                            <td>{{ props.item.score }}</td>
                            <td>{{ props.item.comment }}</td>
                            <td class="justify-center layout px-0">
                                <v-icon
                                        small
                                        class="mr-2"
                                        @click="editItem(props.item)"
                                >
                                    edit
                                </v-icon>
                                <v-icon
                                        small
                                        @click="deleteItem(props.item)"
                                >
                                    delete
                                </v-icon>
                            </td>
                        </template>
                        <template slot="no-data">
                            <v-btn color="primary" @click="initialize">Reset</v-btn>
                        </template>
                    </v-data-table>
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
                'Alabama'
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
        watch: {

            searchProgrammingLanguage(val) {
                val && val !== this.select && this.querySelectionsSearchProgrammingLanguage(val);
                if (!val) {
                    this.selectProgrammingLanguage = null;
                    this.searchAllData();
                    //this.searchAll();
                }

            },

            searchProgrammingLanguage2(val) {
                val && val !== this.select && this.querySelectionsSearchProgrammingLanguage(val);
                if (!val) {
                    this.selectProgrammingLanguage2 = null;
                    this.searchAllData();
                }

            },

            searchLanguage(val) {
                val && val !== this.select && this.querySelectionsSearchLanguage(val);
                if (!val) {
                    this.selectLanguage = null;
                    this.searchAllData();
                    //this.searchAll();
                }
            },
            dialog(val) {
                val || this.close()
            },

        },
        methods: {
            querySelections(v) {
                this.loading = true;
                // Simulated ajax query
                alert('val:' + v);
                setTimeout(() => {
                    this.items = this.states.filter(e => {
                        return (e || '').toLowerCase().indexOf((v || '').toLowerCase()) > -1
                    });
                    this.loading = false
                }, 500)
            },
            querySelectionsSearchProgrammingLanguage(v) {
                this.plloading = true;
                // Simulated ajax query
                // alert('val:'+v);
                // alert('serch prog');


                axios.get('<%=request.getContextPath()%>/getprogramminglanguagelist/' + v)
                    .then((response) => {
                        this.programmingLanguages = response.data;
                        this.searchAllData();
                        //this.searchAll();


                    })
                    .catch(function (error) {
                        // handle error
                        console.log(error);
                    })
                    .then(function () {
                        // always executed

                        // alert('come');

                    });


                setTimeout(() => {
                    this.plitems = this.programmingLanguages.filter(e => {
                        return (e || '').toLowerCase().indexOf((v || '').toLowerCase()) > -1
                    });
                    this.plloading = false
                }, 500);

            },
            querySelectionsSearchLanguage(v) {
                this.lloading = true;

                axios.get('<%=request.getContextPath()%>/getlanguagelist/' + v)
                    .then((response) => {
                        this.languages = response.data;
                        this.searchAllData();
                        //this.searchAll();
                    })
                    .catch(function (error) {
                        // handle error
                        console.log(error);
                    })
                    .then(function () {
                        // always executed
                    });


                setTimeout(() => {
                    this.litems = this.languages.filter(e => {
                        return (e || '').toLowerCase().indexOf((v || '').toLowerCase()) > -1
                    });
                    this.lloading = false
                }, 500)
            },

            updateSeek(event) {
            },
            nameWithLang({name, language}) {
                return `${name} — [${language}]`
            },
            searchAll() {
                var data = {
                    "email": this.selectEmail,
                    "code": this.selectLanguage,
                    "name": this.selectProgrammingLanguage
                };
                axios.post('<%=request.getContextPath()%>/searchalldata', {data})
                    .then(result => {
                        this.tableItems = result.data;
                    })
                    .catch(function (error) {
                    });
            },

            searchAllData() {
                var data = {
                    "firstPLanguage": this.selectProgrammingLanguage,
                    "code": this.selectLanguage,
                    "secondPLanguage": this.selectProgrammingLanguage2
                };
                axios.post('<%=request.getContextPath()%>/searchAllData', {data})
                    .then(result => {
                    this.tableItems = result.data;
            })
            .catch(function (error) {
                });
            },

            searchAll2() {
                var data = {
                    "email": this.selectEmail,
                    "code": this.selectLanguage,
                    "name": this.selectProgrammingLanguage2
                };
                axios.post('<%=request.getContextPath()%>/searchalldata', {data})
                    .then(result => {
                    this.tableItems = result.data;
            })
            .catch(function (error) {
                });
            },

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
