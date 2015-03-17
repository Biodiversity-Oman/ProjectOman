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
            if (o.world.worldId === 1)
            {$plantOrganisms.append('<li><a href="http://www.biodiversity-oman.com/kwartetkaart?id=' + o.organismId + '" target="_blank">' + o.commonName + '</a></li>');}
            else if (o.world.worldId === 2)
            {$animalOrganisms.append('<li><a href="http://www.biodiversity-oman.com/kwartetkaart?id=' + o.organismId + '" target="_blank">' + o.commonName + '</a></li>');}
            else if (o.world.worldId === 3)
            {$marineOrganisms.append('<li><a href="http://www.biodiversity-oman.com/kwartetkaart?id=' + o.organismId + '" target="_blank">' + o.commonName + '</a></li>');}
            else if (o.world.worldId === 4)
            {$microbialOrganisms.append('<li><a href="http://www.biodiversity-oman.com/kwartetkaart?id=' + o.organismId + '" target="_blank">' + o.commonName + '</a></li>');}
            else
            {
                $plantOrganisms.append('<li>No organisms yet</li>');
                $animalOrganisms.append('<li>No organisms yet</li>');
                $marineOrganisms.append('<li>No organisms yet</li>');
                $microbialOrganisms.append('<li>No organisms yet</li>');
            }
        });
    });
};