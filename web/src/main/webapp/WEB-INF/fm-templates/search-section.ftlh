<section class="hero-section set-bg" data-setbg="../../img/koncert.jpg"
         style="background-image: url('../../img/koncert.jpg');" xmlns="http://www.w3.org/1999/html">
    <div class="container">
        <div class="hero-warp">
            <form class="main-search-form" action="search-events">
                <div class="search-type">
                    <div class="st-item">
                        <#--                        <input type="radio" name="st" id="buy" checked="">-->
                        <label for="buy">Wyszukaj wydarzenie</label>
                    </div>
                </div>
                <div class="search-input">
                    <input type="text" title="Wyszukiwanie, wpisz co najmniej 3 znaki" name="eventsearch"
                           class="form-control form-control-user" pattern=".{3,}"
                           id="eventsearch" placeholder="Wyszukiwanie, wpisz co najmniej 3 znaki." autocomplete="off">
                </div>
                <div id="result-div" class="list-group"
                     style="margin-top:2px;position:absolute;margin-left:0;z-index: 1001 !important; ">
                </div>
                <p>Baza wyszukań na podstawie udostępnionych informacji z API miasta Gdańsk.</p>
                <button class="collapsible">Zajawka ulubionego wydarzenia</button>
                <div class="content">
                    <span>
                            <a href="javascript:void(0)" title="More Options"
                               rel="advance" id="options-search" class="search-option-link btn-link" data-toggle="collapse"
                               data-target=".optionsDiv">
                                More Options</a>
                    </span>
                    <input id="datepicker" width="276" name="startDate" title="Data rozpoczęcia"/>
                    </br>
                    <input id="datepicker2" width="276" name="endDate" title="Data zakończenia"/>
                </div>
                <script>
                    var coll = document.getElementsByClassName("collapsible");
                    var i;

                    for (i = 0; i < coll.length; i++) {
                        coll[i].addEventListener("click", function() {
                            this.classList.toggle("active");
                            var content = this.nextElementSibling;
                            if (content.style.maxHeight){
                                content.style.maxHeight = null;
                            } else {
                                content.style.maxHeight = content.scrollHeight + "px";
                            }
                        });
                    }
                </script>
                <script>
                    $('#datepicker').datepicker({
                        uiLibrary: 'bootstrap4'
                    });

                    $('#datepicker2').datepicker({
                        uiLibrary: 'bootstrap4'
                    });
                </script>
            </form>
        </div>
    </div>
</section>