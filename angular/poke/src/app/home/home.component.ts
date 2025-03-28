import { Component, OnInit } from '@angular/core';
import { PokemonService } from '../services/pokemon.service';
import { Pokemon } from '../Pokemon';
import { AlertController, ToastController } from '@ionic/angular';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  pokemonsList: Pokemon[] = [];
  showModal: boolean = false;
  pokemonForm: Pokemon = {
    id: undefined,
    name: '',
    type: ''
  };
  pokemon?: Pokemon;

  constructor(private readonly pokemonService: PokemonService,
    private readonly toastController: ToastController,
    private readonly alertController: AlertController) { }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.pokemonService.getAllPokemon().subscribe(pokemons => {
      this.pokemonsList = pokemons;
    });
  }

  openForm(pokemon?: Pokemon) {
    this.pokemon = pokemon || undefined;
    this.pokemonForm = pokemon ? { ...pokemon } : { id: undefined, name: '', type: '' };
    this.showModal = true;
  }

  closeModal() {
    this.showModal = false;
  }

  savePokemon() {
    if (this.pokemonForm.id) {
      this.pokemonService.updatePokemon(this.pokemonForm.id, this.pokemonForm).subscribe(() => {
        this.closeModal();
        this.getAll();
        this.presentToast('Pokémon atualizado com sucesso!', 'success');
      });
    } else {
      this.pokemonService.createPokemon(this.pokemonForm).subscribe(() => {
        this.closeModal();
        this.getAll();
        this.presentToast('Pokémon criado com sucesso!', 'success');
      });
    }
  }

  onDelete(id: number | undefined) {
    if (id) {
      this.pokemonService.deletePokemon(id).subscribe(() => {
        this.getAll();
        this.presentToast('Pokémon excluído com sucesso!', 'success');
      });
    }
  }

  async presentToast(message: string, color: 'success' | 'danger') {
    const toast = await this.toastController.create({
      message: message,
      duration: 3000,
      position: 'bottom',
      color: color,
      icon: color === 'success' ? 'checkmark-circle-outline' : 'alert-circle-outline'
    });
    await toast.present();
  }

  async confirmarExclusao(id: number | undefined) {
    const alert = await this.alertController.create({
      header: 'Confirmação',
      message: 'Tem certeza que deseja excluir este Pokémon?',
      buttons: [
        {
          text: 'Cancelar',
          role: 'cancel',
          handler: () => {
            console.log('Exclusão cancelada');
          },
        },
        {
          text: 'Excluir',
          role: 'destructive',
          handler: () => {
            this.onDelete(id);
          },
        },
      ],
    });
  
    await alert.present();
  }
}