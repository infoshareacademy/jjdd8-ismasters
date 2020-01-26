
<section class="hero-section set-bg" data-setbg="../../img/koncert.jpg" style="background-image: url('../../img/koncert.jpg');">
    <div class="container">
        <div class="hero-warp">
            <form class="main-search-form">
                <div class="search-type">
                    <div class="st-item">
                        <input type="radio" name="st" id="buy" checked="">
                        <label for="buy">Wyszukaj wydarzenie</label>
                    </div>
                </div>
                <div class="search-input">
                    <input type="text" title="Wyszukiwanie, wpisz co najmniej 3 znaki" name="eventsearch" class="form-control form-control-user" pattern=".{3,}"
                           id="eventsearch" placeholder="Wyszukiwanie, wpisz co najmniej 3 znaki." autocomplete="off"></div>
                <div id="result-div" class="list-group" style="margin-top:2px;position:absolute;margin-left:0;z-index: 1001 !important; ">
                </div>

                <p>Baza wyszukań na podstawie udostępnionych informacji z API miasta Gdańsk.</p>
            </form>
        </div>
    </div>
</section>