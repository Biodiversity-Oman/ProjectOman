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

//search function in index.jsp

    $('#form-search-organism').submit(function (e){
        document.getElementById('#search-organism-published').style.display ='block';

        var keyword = $(this).val();
        $.ajax({
            url: 'SearchOrganism',
            type: 'GET',
            dataType: 'json',
            cache: false,
            async: true,
            data: 'organismkey=' + keyword,
            beforesend: function(){
                $('#search-result').html('');      
            }
        }).done(function (data){
             if (data.length === 0) {
                        $('#search-result').append('<p>Organism not found</p>');
                    };
            data.forEach(function (o){           
                $('#search-result').append('<p>' + o.commonName + '</p>');
                
            });
        });

    });