
// functie om organisme te laden per wereld in index.jsp
function loadOrganisms() {

    var $marineOrganisms = $('#marine-organisms');
    var $animalOrganisms = $('#animal-organisms');
    var $plantOrganisms = $('#plant-organisms');
    var $microbialOrganisms = $('#microbial-organisms');
    $.ajax({
        url: 'SelectAllOrganismByWorld',
        type: 'GET',
        dataType: 'json',
        cache: false,
        async: true
    }).done(function (data) {
        data.forEach(function (o) {
            if (o.world.worldName.toLowerCase().indexOf('plant') > -1)
            {
                $plantOrganisms.append('<a href="organism?id=' + o.organismId + '"><div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 organisms-list organisms-plant-world"><li>' + o.commonName + '</li></div></a>');
            }
            else if (o.world.worldName.toLowerCase().indexOf('animal') > -1)
            {
                $animalOrganisms.append('<a href="organism?id=' + o.organismId + '"><div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 organisms-list organisms-animal-world"><li>' + o.commonName + '</li></div></a>');
            }
            else if (o.world.worldName.toLowerCase().indexOf('marine') > -1)
            {
                $marineOrganisms.append('<a href="organism?id=' + o.organismId + '"><div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 organisms-list organisms-marine-world"><li>' + o.commonName + '</li></div></a>');
            }
            else if (o.world.worldName.toLowerCase().indexOf('microbial') > -1)
            {
                $microbialOrganisms.append('<a href="organism?id=' + o.organismId + '"><div class="col-lg-3 col-md-3 col-sm-3 col-xs-12 organisms-list organisms-microbial-world"><li>' + o.commonName + '</li></div></a>');
            }
            else
            {
                $plantOrganisms.append('<li>No organisms yet</li>');
                $animalOrganisms.append('<li>No organisms yet</li>');
                $marineOrganisms.append('<li>No organisms yet</li>');
                $microbialOrganisms.append('<li>No organisms yet</li>');
            }
        });
    });
}
;

//search function in index.jsp
$(document).ready(function () {

    $('#form-search-organism').submit(function (e) {
        $('#search-result').html('');
        var keyword = $('#keyword').val();
        if (keyword.length >= 3) {
            $.ajax({
                url: 'SearchOrganism',
                type: 'GET',
                dataType: 'json',
                cache: false,
                async: true,
                data: $('#form-search-organism').serialize()
            }).done(function (data) {
                document.getElementById('search-result').style.display = 'block';
                if (data.length === 0) {
                    $('#search-result').append('<p>Organism not found</p>');
                }
                ;
                data.forEach(function (o) {
                    $('#search-result').append('<p><a href="ViewOrganism?id=' + o.organismId + '" >' + o.commonName + '</a></p>');
                });
                setTimeout(function () {
                    $('#search-result').html('');
                    $('#form-search-organism')[0].reset();
                }, 15000);
            });
        } else {
            document.getElementById('search-result').style.display = 'block';
            $('#search-result').append('<p>More characters required</p>');
        }
        e.preventDefault();
    });


// Add subscriber in index.jsp
    $('#create-subscriber-form').submit(function (e) {
        if ($('#create-subscriber-form').find('.has-error').length)
            return;
        var $message = $('#create-subscriber-message');
        $message.show();
        $.ajax({
            url: 'InsertSubscriber',
            type: 'POST',
            dataType: 'text',
            data: $('#create-subscriber-form').serialize()
        }).done(function (data) {

            if (data === 'succes') {
                $message.append('<div class="alert alert-success" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Subscribed succesfull</div>');
            } else if (data === 'exists') {
                $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Email already exists</div>');
            } else if (data === 'sql') {
                $message.append('<div class="alert alert-danger" role="alert"><a href="#" class="close" data-dismiss="alert">&times;</a>Service unavailable!</div>');
            }
            setTimeout(function () {
                $message.fadeOut('slow');
                $message.empty();
            }, 2800);
            $("#create-subscriber-form")[0].reset();
        });
        e.preventDefault();

    });
});