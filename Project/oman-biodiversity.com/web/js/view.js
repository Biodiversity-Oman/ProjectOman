
// functie om organisme te laden per wereld in index.jsp
function loadOrganisms() {

    var $marineOrganisms = $('#marine-organisms');
    var $animalOrganisms = $('#animal-organisms');
    var $plantOrganisms = $('#plant-organisms');
    var $microbialOrganisms = $('#microbial-organisms');
    var world;
    $.ajax({
        url: 'SelectAllOrganismByWorld',
        type: 'GET',
        dataType: 'json',
        cache: false,
        async: true
    }).done(function (data) {
        data.forEach(function (o) {
            world = o.world.worldName;
            console.log(world);
            if (world.toLowerCase().contains("plant"))
            {
                $plantOrganisms.append('<li><a href="ViewOrganism?id=' + o.organismId + '" >' + o.commonName + '</a></li>');
            }
            else if (world.toLowerCase().contains("animal"))
            {
                $animalOrganisms.append('<li><a href="ViewOrganism?id=' + o.organismId + '" >' + o.commonName + '</a></li>');
            }
            else if (world.toLowerCase().contains("marine"))
            {
                $marineOrganisms.append('<li><a href="ViewOrganism?id=' + o.organismId + '" >' + o.commonName + '</a></li>');
            }
            else if (world.toLowerCase().contains("micro"))
            {
                $microbialOrganisms.append('<li><a href="ViewOrganism?id=' + o.organismId + '" >' + o.commonName + '</a></li>');
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
        e.preventDefault();
    });
});
