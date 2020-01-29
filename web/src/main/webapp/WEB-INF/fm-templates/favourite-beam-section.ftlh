<section>
    <style>
        .ShowHide {
            overflow: hidden;
            font-family: Arial, Helvetica, sans-serif;
            background-color: #555555;
            color: #FFFFFF;
            padding: 4px;
        }

        #left {
            overflow: hidden;
            text-align: center;
            height: 35px;
            padding-top: 13px;
        }

        #right {
            float: right;
            width: 30px;
            height: 35px;
            text-align: center;
        }

        #bottomNameDate {
            padding: 7px;
            background-color: #777777;
            width: 20%;
            height: 70px;
            float: left;
            display: inline-block;
        }

        #bottomText {
            padding: 7px;
            background-color: #999999;
            height: 70px;
            display: inline-block;
        }

        .ShowHide a {
            color: #FFFFFF;
            text-decoration: none;
        }
    </style>
    <div class="ShowHide" id="Bar">
        <div id="right">
            <a href="#" onclick="Hide(Bar);">&#9746;</a>
        </div>
        <div id="left">
            Zajawka ulubionego wydarzenia
        </div>
        <div id="bottomNameDate">
            Nazwa
            <br>
            data
        </div>
        <div id="bottomText">
            opis
        </div>
    </div>
    <script>
        function Hide(HideID) {
            HideID.style.display = "none";
        }
    </script>
</section>